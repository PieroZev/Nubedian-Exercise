FROM hello-world
CMD dnf module install nodejs:<stream>
CMD tar -xvf apache-maven-3.3.9-bin.tar.gz -C /usr/local/apache-maven/apache-maven-3.3.9
COPY . /Exercise-web
RUN make /Exercise-web/nubedian-app
CMD npm start
COPY . /Exercise
RUN make /Exercise/src/main/java/Nerubian/Exercise/App
cmd mvn start
