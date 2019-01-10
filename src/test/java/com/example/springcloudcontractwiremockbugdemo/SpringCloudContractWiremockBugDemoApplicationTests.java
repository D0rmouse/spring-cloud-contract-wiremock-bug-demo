package com.example.springcloudcontractwiremockbugdemo;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudContractWiremockBugDemoApplicationTests {

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(
            WireMockSpring.options().dynamicPort().notifier(new ConsoleNotifier(true)));
    @Value("${wiremock.server.port}")
    private Integer wireMockServerPort;

    @Test
    public void contextLoads() {
        assertThat(wireMockServerPort).isEqualTo(wireMockRule.port());
    }

}

