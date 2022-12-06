#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5



if [ $# -ne 5 ]; then
          echo 'Missing Argument (HOST PORT NAME USER PWD)'
          exit 1
fi

lscpu_out=$(lscpu)
hostname=$(hostname -f)

cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $NF}' | xargs)
cpu_architecture=$(echo "$lscpu_out"  | egrep "^Architecture:" | awk '{print $NF}' | xargs)
cpu_model=$(echo "$lscpu_out"  | egrep "^Model.*:" | awk '{print $NF}' | xargs)
cpu_mhz=$(echo "$lscpu_out"  | egrep "^CPU MHz:" | awk '{print $NF}' | xargs)
l2_cache=$(echo "$lscpu_out"  | egrep "^L2 cache:" | awk '{print substr($3, 1 , length($3)-1)}'| xargs)

meminfo_out=$(cat /proc/meminfo)

total_mem=$(echo "$meminfo_out"  | egrep "^MemTotal:" | awk '{print $2}' | xargs)
current_timestamp=$(date '+%s')
timestamp=$(date -d "1970-01-01 $current_timestamp sec GMT")

insert_stmt=" INSERT INTO host_info(hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, total_mem, timestamp)
              VALUES('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$total_mem', '$timestamp')"

export PGPASSWORD=$psql_password
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?