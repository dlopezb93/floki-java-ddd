package com.eccco.floki.shared.application.pipelinr;

import an.awesome.pipelinr.Command;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class ValidationMiddleware implements Command.Middleware {
    private final ObjectProvider<CommandValidator> validators;

    ValidationMiddleware(ObjectProvider<CommandValidator> validators) {
        this.validators = validators;
    }

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        validators.stream().filter(v -> v.matches(command)).findFirst().ifPresent(v -> v.validate(command));
        return next.invoke();
    }
}
