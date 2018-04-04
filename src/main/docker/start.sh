#!/bin/bash

#replace couchbase configuration in application.properties
#sed -i "s/\$COUCHBASE_HOST/$COUCHBASE_HOST/g" /etc/verve/sdkconfig/application.properties
#sed -i "s/\$COUCHBASE_PORT/$COUCHBASE_PORT/g" /etc/verve/sdkconfig/application.properties

"catalina.sh" "run"
