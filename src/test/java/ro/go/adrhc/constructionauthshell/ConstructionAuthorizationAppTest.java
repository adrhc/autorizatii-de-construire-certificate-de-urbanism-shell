package ro.go.adrhc.constructionauthshell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;

@SpringBootTest(properties = "index.readonly=true")
@ExcludeShellAutoConfiguration
@MockBean(classes = {Shell.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConstructionAuthorizationAppTest {
    @Test
    void contextLoads() {
    }
}