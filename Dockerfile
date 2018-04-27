# Download the tomcat image
# Let us see what needs we have for this, and we will consider alpine and slim.
# Usually a good practice if we put docker in the main-dir.
From tomcat:8.5

# Copy the .war file to the webapps dir of the container
COPY build/libs/config-debug.war webapps/

# Copy the environment to bin where catalina.sh is located
# Has the password, and username for the database
# This can be extracted from System.getProperty("value")
COPY setenv.sh bin/

# Add required permissions
RUN chmod +x bin/*.sh

# expose default tomcat port
EXPOSE 8080

# Run tomcat
CMD ["catalina.sh", "run"]