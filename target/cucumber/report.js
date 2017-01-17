$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: piuskurianau@gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Login"
    },
    {
      "line": 3,
      "value": "# This feature file documents the login functionality for the nopcommerce"
    },
    {
      "line": 4,
      "value": "# website"
    }
  ],
  "line": 5,
  "name": "Login feature for nopcommerce",
  "description": "As a user I want to login to the system when I provide username and password",
  "id": "login-feature-for-nopcommerce",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 9,
  "name": "Login failure with unregistered user.",
  "description": "",
  "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I launch \"http://demo.nopcommerce.com/login\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I am not a registered user with \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I login with unregistered \u003cemail\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify my login \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "status"
      ],
      "line": 16,
      "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;;1"
    },
    {
      "cells": [
        "abc@def.com",
        "asdf123",
        "failure"
      ],
      "line": 17,
      "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;;2"
    },
    {
      "cells": [
        "abc@dfgrjj.com",
        "fghdk123",
        "failure"
      ],
      "line": 18,
      "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3106691226,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Login failure with unregistered user.",
  "description": "",
  "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I launch \"http://demo.nopcommerce.com/login\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I am not a registered user with abc@def.com",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I login with unregistered abc@def.com and asdf123",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify my login failure",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://demo.nopcommerce.com/login",
      "offset": 10
    }
  ],
  "location": "LoginPageStepDefinition.launchPage(String)"
});
formatter.result({
  "duration": 4449701918,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc@def.com",
      "offset": 32
    }
  ],
  "location": "LoginPageStepDefinition.isRegisteredUser(String)"
});
formatter.result({
  "duration": 2593059840,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc@def.com",
      "offset": 26
    },
    {
      "val": "asdf123",
      "offset": 42
    }
  ],
  "location": "LoginPageStepDefinition.login(String,String)"
});
formatter.result({
  "duration": 2317379060,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "failure",
      "offset": 16
    }
  ],
  "location": "LoginPageStepDefinition.verifyLogin(String)"
});
formatter.result({
  "duration": 142902,
  "status": "passed"
});
formatter.after({
  "duration": 927577710,
  "status": "passed"
});
formatter.before({
  "duration": 2059190004,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Login failure with unregistered user.",
  "description": "",
  "id": "login-feature-for-nopcommerce;login-failure-with-unregistered-user.;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I launch \"http://demo.nopcommerce.com/login\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I am not a registered user with abc@dfgrjj.com",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I login with unregistered abc@dfgrjj.com and fghdk123",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify my login failure",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://demo.nopcommerce.com/login",
      "offset": 10
    }
  ],
  "location": "LoginPageStepDefinition.launchPage(String)"
});
formatter.result({
  "duration": 2649814187,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc@dfgrjj.com",
      "offset": 32
    }
  ],
  "location": "LoginPageStepDefinition.isRegisteredUser(String)"
});
formatter.result({
  "duration": 2450631178,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc@dfgrjj.com",
      "offset": 26
    },
    {
      "val": "fghdk123",
      "offset": 45
    }
  ],
  "location": "LoginPageStepDefinition.login(String,String)"
});
formatter.result({
  "duration": 2288304349,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "failure",
      "offset": 16
    }
  ],
  "location": "LoginPageStepDefinition.verifyLogin(String)"
});
formatter.result({
  "duration": 105795,
  "status": "passed"
});
formatter.after({
  "duration": 849454327,
  "status": "passed"
});
});