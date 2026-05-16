<template>
  <el-container style="height: 100vh; background: #f0f2f5;">
    <!----------------------------------左侧-------------------------------------------->
    <el-aside width="200px" style="background: white;margin: 10px;border-radius: 12px;box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);padding: 10px;">
      <el-header style="background: white;margin: 5px 0 15px 0;;border-radius: 12px;box-shadow: 0 2px 12px rgba(0, 0, 0, 0.15);padding: 10px;">

      </el-header>
        <el-menu router default-active="/home" style="border-right: none;">
          <el-menu-item index="/home">数据监测</el-menu-item>
          <el-menu-item index="/user">用户管理</el-menu-item>
          <el-menu-item index="/product">商品管理</el-menu-item>
          <el-menu-item index="/order">订单管理</el-menu-item>
        </el-menu>
    </el-aside>


    <!----------------------------------右侧-------------------------------------------->
    <el-container>
      <el-main style="background: white;margin: 10px;border-radius: 12px;box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);">
        <router-view></router-view>
      </el-main>

    </el-container>


  </el-container>
</template>

<script setup>
</script>

<style>

.el-menu-item {
  font-size: 20px !important;
  border-radius: 4px;
  display: flex;
  align-items: center;
  justify-content: center;
  letter-spacing: 3px;
}


.el-menu-item:hover {
  background-color: #f9fafb !important;
  color: #409eff !important;
}


</style>