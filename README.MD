**Allure Configuration with Kotlin DSL**

_Sample project to illustrate issue with allure-gradle plugin when project built with Gradle 5.0 and Kotlin DSL_


Steps to reproduce:

1. Import repository as gradle project
2. Open gradle console
3. in 'verification' tab execute 'test' task
4. in 'other' tab execute task 'allureServe'
5. Check that report is generated as expected
6. repeat step 4, run 'test' again (without cleaning project)

Expected result: test should run
Actual result: build fails with following error:
"Cannot write to file '/allure-kotlin/build/allure-results' specified for property '$1' as it is a directory."