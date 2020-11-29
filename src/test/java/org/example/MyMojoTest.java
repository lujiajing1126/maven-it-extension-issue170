package org.example;


import com.soebes.itf.jupiter.extension.MavenGoal;
import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenITAssertions.assertThat;

@MavenJupiterExtension
class FirstMavenIT {

    @MavenTest
    @MavenGoal("${project.groupId}:${project.artifactId}:${project.version}:touch")
    void the_first_test_case(MavenExecutionResult result) {
        assertThat(result).isSuccessful();
        assertThat(result).out().info().contains("BUILD SUCCESS");
    }

}

