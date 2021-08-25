FROM hello-world
CMD dnf module install nodejs:<stream>
CMD npm start
