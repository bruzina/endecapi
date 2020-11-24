# EnDec API

Simple and small demo Springboot application providing API for simple ciphers.

## Prerequisites

```bash
apt install -y openjdk-11-jre openjdk-11-jdk
echo "JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/" >> /etc/environment
snap install postman # Run and sign in manually afterwards
```

## Commands

```bash
./gradlew check && ./gradlew test # Verification
./gradlew bootRun # Run
```

## License

[Proprierary](LICENSE)

## Sources

### Tools

- [Spring Initializr](https://start.spring.io/)

### Guides

- [How to Install OpenJDK JAVA 11/8 in Ubuntu and Debian](https://tecadmin.net/install-openjdk-java-ubuntu/)
- [Spring | Guides | Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Linuxize | How to Install Postman on Ubuntu 20.04](https://linuxize.com/post/how-to-install-postman-on-ubuntu-20-04/)
- [Spring | Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Documentation

- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/gradle-plugin/reference/htmlsingle/)
- [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)
- [Postman | Documentation](https://learning.postman.com/docs/)

### See Also

- [Wikipedia - Caesar cipher](https://en.wikipedia.org/wiki/Caesar_cipher)
- [Wikipedia - ROT13](https://en.wikipedia.org/wiki/ROT13)
