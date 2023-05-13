### Run the unit tests
```
mvn clean test
```

### Complete
``` 
mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=16 -DtimestampedReports=false
```

## Unit Test and Mutation Test Results

### Test: initializingBookmarkToolCreatesBookmarkTool
Line Coverage = 100%
Mutation Coverage = 100%

### Test: createBookmarkCreatedBookmark
Line Coverage = 100%
Mutation Coverage = 100%

### Test: addBookmarkToBookmarklistAddsBookmarkToList
Line Coverage = 100%
Mutation Coverage = 100%

### Test: invalidURLthrowsException
Line Coverage = 100%
Mutation Coverage = 100%

Test
