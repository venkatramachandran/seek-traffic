# seek-traffic

## Running
Executing the main logic needs an input file as a mandatory param. For example, using the sample.txt should be run using
`./gradlew run --args build/resources/main/sample.txt`

## Testing
unit tests can be run using `./gradlew test`.

## TO DO
- [ ] Add more unit tests
- [ ] For the least traffic seen in 90 minutes, figure out a way to make 90 minutes as configurable/parameter
- [ ] For the least traffic seen in 90 minutes, figure out a way to return both start and end time