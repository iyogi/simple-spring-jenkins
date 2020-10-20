## Sample project to save artifact to local artifactory, do jenkins integration etc

### Build
`mvn clean install`

### Run
`mvn spring-boot:run`

### Verify
`curl -X GET http://localhost:9090/users/whoami`



## Save artifact to local artifactory

1. run artifactort in docker

```
docker run --rm -p 8081:8081 --name artifactory docker.bintray.io/jfrog/artifactory-oss:5.4.4
```



2. ensure that settings.xml has this entry, replacing ${ARTIFACTORY_PWD} with actual credential
```
<servers>
	<server>
	<id>artifactory-local</id>  // should match id in <distributionManagement> section below
	<username>admin</username>
	<password>${ARTIFACTORY_PWD}</password>
	</server>
</servers>
```

3a. Now you can either use maven release plugin to release - prepare and perform - to artifactory (used normally for saving release version to artifactory)
```
mvn -B release:clean release:prepare release:perform "-Darguments=-Dartifactory_url=http://localhost:8081/artifactory/example-repo-local"  
```

OR

3b. Use maven deploy plugin to only save to artifactory (used normally for saving current snapshot version)
```
mvn deploy -DskipTests -Dartifactory_url=http://localhost:8081/artifactory/example-repo-local
```



## Jenkins integration
### See ~/Workspaces/CI-CD/learning/x/docker_jenkins_notes.txt
