@echo off
setlocal enabledelayedexpansion
set port=0000
if %env% == dev (
  if %project_name% == zmph-shop-eurake  (
     set port=7000
  )
  if %project_name% == zmph-config-client  (
     set port=7100
  )
  if %project_name% == zmph-config-server (
     set port=7200
  )
  if %project_name% == zmph-shop-usersrv  (
     set port=7300
  )
  if %project_name% == zmph-shop-productsrv (
     set port=7400
  )
  if %project_name% == zmph-shop-web (
     set port=7500
  )
)
if %env% == sit (
  if %project_name% == zmph-shop-eurake  (
     set port=7001
  )
  if %project_name% == zmph-config-client  (
     set port=7101
  )
  if %project_name% == zmph-config-server (
     set port=7200
  )
  if %project_name% == zmph-shop-usersrv  (
     set port=7301
  )
  if %project_name% == zmph-shop-productsrv (
     set port=7401
  )
  if %project_name% == zmph-shop-web (
     set port=7501
  )
)
if %env% == uat (
  if %project_name% == zmph-shop-eurake  (
     set port=7002
  )
  if %project_name% == zmph-config-client  (
     set port=7102
  )
  if %project_name% == zmph-config-server (
     set port=7200
  )
  if %project_name% == zmph-shop-usersrv  (
     set port=7302
  )
  if %project_name% == zmph-shop-productsrv (
     set port=7402
  )
  if %project_name% == zmph-shop-web (
     set port=7502
  )
)
if %env% == prod (
  if %project_name% == zmph-shop-eurake  (
     set port=7003
  )
  if %project_name% == zmph-config-client  (
     set port=7103
  )
  if %project_name% == zmph-config-server (
     set port=7200
  )
  if %project_name% == zmph-shop-usersrv  (
     set port=7303
  )
  if %project_name% == zmph-shop-productsrv (
     set port=7403
  )
  if %project_name% == zmph-shop-web (
     set port=7503
  )
)

echo 当前环境= %env%
echo 当前项目=  %project_name%
echo 当前端口= %port%

for /f "tokens=1-5" %%a in ('netstat -ano ^| find ":%port%"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
         set pid=%%e
    )
    echo pid
)
if NOT "!pid!" == "" (
   taskkill /f /pid !pid!
)