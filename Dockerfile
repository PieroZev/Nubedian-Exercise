FROM hello-world
CMD dnf module install nodejs:<stream>
CMD tar -xvf apache-maven-3.3.9-bin.tar.gz -C /usr/local/apache-maven/apache-maven-3.3.9
COPY . /Exercise-web
CMD cd /Exercise-web/nubedian-app
CMD npm start
COPY . /Exercise
CMD cd /Exercise
CMD mvn clean compile exec:java
