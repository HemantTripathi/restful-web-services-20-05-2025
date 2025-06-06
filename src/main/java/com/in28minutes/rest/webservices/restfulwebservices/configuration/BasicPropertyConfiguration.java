package com.in28minutes.rest.webservices.restfulwebservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicPropertyConfiguration {

        String information;
        String portNumber;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public String toString() {
        return "BasicPropertyConfiguration{" +
                "information='" + information + '\'' +
                ", portNumber='" + portNumber + '\'' +
                '}';
    }
}
