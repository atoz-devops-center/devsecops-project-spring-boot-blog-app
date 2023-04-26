package gb.app.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeAll;

abstract class ArchitectureTest {
    static final String DOMAIN_LAYER_PACKAGES = "gb.app.domain..";
    static final String SERVICE_LAYER_PACKAGES = "gb.app.modules..";
    static final String WEB_LAYER_CLASSES = "gb.app.web..";
    static final String CONFIG_PACKAGE = "gb.app.config..";

    static JavaClasses classes;

    @BeforeAll
    public static void setUp() {
        classes = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
            .importPackages("gb.app");
    }


}
