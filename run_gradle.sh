docker-compose --file docker/docker-compose.yml down
docker rmi chat_app/backend
./gradlew bootBuildImage && docker-compose --file docker/docker-compose.yml up