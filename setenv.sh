#!/bin/sh

# Export the credential
export COUCHBASE_PASSWORD=couchBasePassword
export COUCHBASE_USERNAME=couchBaseUserName

# Find and replace db environment variables
sed -i "s/\$COUCHBASE_HOST/$COUCHBASE_HOST/g" ./setenv.sh
sed -i "s/\$COUCHBASE_PORT/$COUCHBASE_PORT/g" ./setenv.sh

# Export the port and host name
export $COUCHBASE_HOST
export $COUCHBASE_PORT

