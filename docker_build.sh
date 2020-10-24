SERVICE_COMPONENT="statsapi"

./gradlew clean build -x test
docker build --build-arg JAR_FILE=build/libs/*.jar -t rivalchess-vie-$SERVICE_COMPONENT .