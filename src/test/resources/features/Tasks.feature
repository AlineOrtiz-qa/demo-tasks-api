Feature: This is a sample features test

  Scenario: client makes call to GET /tasks
    When the client calls GET Tasks
    Then the api returns with status code 200

Scenario: client maskes call to POST /task
    When the client sends a POST request to Tasks with payload
      """
      {
        "title": "new year",
        "description": "happy new year",
        "completionDate": "2025-01-01T00:00:01",
        "completed": false
      }
      """
    Then the api returns a success status code 200
    And the response contains the created task with title "new year"