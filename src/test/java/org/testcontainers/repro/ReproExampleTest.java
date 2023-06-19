package org.testcontainers.repro;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import java.nio.file.Paths;
import java.time.Duration;

public class ReproExampleTest {

    private static final Logger LOG = LoggerFactory.getLogger(ReproExampleTest.class);

    /**
     * Placeholder for a piece of code that demonstrates the bug. You can use this as a starting point, or replace
     * entirely.
     * <p>
     * Ideally this would be a failing test. If it's excessively difficult to form as a test (e.g. relates to log
     * output, teardown or other side effects) then it would be sufficient to explain the behaviour in the issue
     * description.
     */
    @Test
    public void demonstration() {
        try (
                // customize the creation of a container as required
                DockerComposeContainer<?> environment = new DockerComposeContainer<>(
                        Paths.get("docker/docker-compose.yml").toFile())
                        .withLocalCompose(true)
                        .withOptions("--compatibility")
                        .withStartupTimeout(Duration.ofSeconds(1000))
                        .waitingFor("redis", Wait.forHealthcheck());
        ) {
            environment.start();

            // ...
        }
    }
}
