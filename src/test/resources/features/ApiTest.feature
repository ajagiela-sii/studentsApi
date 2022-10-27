Feature: Student Details Api Testing

  Scenario Outline: Add a new student to the system, then update their surname and remove them from the system
    Given New student '<First_name>', '<Middle_name>', '<Surname>', '<Date_of_birth>' is going to join to school
    When Student details are added to the system
    Then Students details are available in the system
    When Student changed his surname to '<New_surname>'
    Then Students details are available in the system
    When Student graduated from school
    Then Student details are removed from the system

    Examples:
      | First_name | Middle_name | Surname  | Date_of_birth | New_surname |
      | Angelina   | Anna        | Jolie    | 02-12-1977    | Nowak       |
      | Brad       | Janusz      | Pitt     | 23-03-1973    | Kowalski    |

