source /e/project/dust_responsive/front.sh
source ./backend.sh


function run_container() {
    remote_cmd_front="docker run --name dust_front -d -p 9090:80  nizhenshi/dust_front:latest"
    remote_cmd_backend="docker run --name backend -d -p 7861:5000 --network database_dust  nizhenshi/dust_backend:latest"
    ssh $ROMOTE_USER@$ROMOTE_HOST "cd /root/user;$remote_cmd_front"
    ssh $ROMOTE_USER@$ROMOTE_HOST "cd /root/user;$remote_cmd_front $remote_cmd_backend"
    if [[ $? -eq 0 ]];then
      echo "执行成功"
    else
      echo "执行失败"
    fi
}

front_to_remote &
front=$!
backend_to_remote &
backend=$!
wait $front
wait $backend

run_container


