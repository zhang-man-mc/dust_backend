source /e/project/dust_responsive/front.sh
source ./backend.sh


function run_container() {
    remote_cmd_front="docker rm -f dust_front;docker rmi nizhenshi/dust_front;docker load -i dust_front.tar;docker run --name dust_front -d -p 9090:80  nizhenshi/dust_front:latest"
#    remote_cmd_backend="docker rm -f dust_backend;docker rmi nizhenshi/dust_backend;docker load -i dust_backend.tar;docker run --name dust_backend -d -p 7861:7861 --network database_dust  -e DATABASE_IP=mysql -e DATABASE_USER=dust -e DATABASE_PASS=1234 nizhenshi/dust_backend:latest"
    ssh $ROMOTE_USER@$ROMOTE_HOST "cd /root/user/dust;$remote_cmd_front"
#    ssh $ROMOTE_USER@$ROMOTE_HOST "cd /root/user/dust;$remote_cmd_front $remote_cmd_backend"
    if [[ $? -eq 0 ]];then
      echo "执行成功"
    else
      echo "执行失败"
    fi
}

#front_to_remote &
#front=$!
#backend_to_remote &
#backend=$!
#wait $front
#wait $backend

run_container


