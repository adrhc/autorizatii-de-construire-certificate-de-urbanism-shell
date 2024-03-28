package ro.go.adrhc.constructionauthshell.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.shell.boot.NonInteractiveShellRunnerCustomizer;
import ro.go.adrhc.constructionauth.ConstructionAuthConfig;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Import(ConstructionAuthConfig.class)
@RequiredArgsConstructor
public class AppConfiguration {
    @Bean
    public NonInteractiveShellRunnerCustomizer nonInteractiveShellRunnerCustomizer() {
        return shellRunner -> shellRunner.setCommandsFromInputArgs(this::skipSpringBootParams);
    }

    private List<String> skipSpringBootParams(ApplicationArguments appArgs) {
        String command = Stream.of(appArgs.getSourceArgs())
                .filter(arg -> !arg.startsWith("--spring."))
                .collect(Collectors.joining(" "));
        return command.isBlank() ? List.of() : Collections.singletonList(command);
    }
}
