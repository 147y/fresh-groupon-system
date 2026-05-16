<template>
  <div style="height: 100%;">
    <!-- 顶部一行：标题卡片 + 搜索框 + 按钮 -->
    <div style="display: flex; align-items: center; gap: 12px; margin-bottom: 20px;">
      <!-- 标题卡片 -->
      <div style="background: #ffffff; border-radius: 12px; box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1); padding: 10px 20px;">
        <h3 style="margin: 5px; font-size: 20px; font-weight: 500;">用户管理</h3>
      </div>

      <div style="background: #ffffff; border-radius: 12px; box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1); padding: 10px 20px;flex-grow: 1;display: flex">
        <div style="flex-grow: 1;"></div>
        <!-- 搜索框 -->
        <el-input
            v-model="keywords"
            placeholder="请输入用户名"
            style="width: 400px;height: 40px"
            clearable
        />
        <!-- 查询按钮 -->
        <el-button type="primary" style="height: 38px;margin-left: 10px" @click="loadData">查询</el-button>
      </div>
    </div>

    <!-- 表格区域 -->
    <div style="background: #ffffff; border-radius: 12px; box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1); padding: 10px 20px;height: 90%;display: flex;flex-direction: column;">
      <div style="background: #fff; border-radius: 8px; overflow: hidden;flex: 1;">
        <el-table :data="userList" border style="width: 100%">
          <el-table-column label="ID" prop="id" />
          <el-table-column label="用户名" prop="username" />

          <!-- 👇 就在这里加了一列：用户姓名 -->
          <el-table-column label="用户姓名" prop="nickname" />

          <el-table-column label="手机号" prop="phone" />
          <el-table-column label="创建时间" prop="createTime" />

          <!-- 操作列：修改/删除 -->
          <el-table-column label="操作" width="150">
            <template #default="scope">
              <div style="display: flex; justify-content: center;">
                <el-button type="primary" size="small" @click="handleEdit(scope.row)">修改</el-button>
                <el-button type="danger" size="small" style="margin-left: 10px" @click="handleDelete(scope.row)">删除</el-button>
              </div>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!-- 分页组件 -->
      <div style="display: flex; justify-content: flex-end; margin-top: 15px;">
        <el-pagination
            v-model:current-page="pageNum"
            v-model:page-size="pageSize"
            :total="total"
            :page-sizes="[5, 10, 20]"
            layout="total, sizes, prev, pager, next, jumper"
            @size-change="handlePageChange"
            @current-change="handlePageChange"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getUserPage, getUsersByName, deleteUser } from '../api/user.js'

const userList = ref([])
const keywords = ref('')
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)

// 页面加载
onMounted(() => {
  loadData()
})

// 加载数据（分页 + 搜索）
async function loadData() {
  try {
    let res
    if (keywords.value.trim()) {
      res = await getUsersByName(keywords.value)
      userList.value = res.data.data
      total.value = userList.value.length
    } else {
      res = await getUserPage(pageNum.value, pageSize.value)
      userList.value = res.data.data.list
      total.value = res.data.data.total
    }
  } catch (err) {
    console.error('加载失败', err)
  }
}

// 分页变化时刷新数据
function handlePageChange() {
  loadData()
}

// 修改按钮
function handleEdit(row) {
  alert('修改用户：' + row.username)
}

// 删除按钮
async function handleDelete(row) {
  if (!confirm('确定要删除用户 ' + row.username + ' 吗？')) return
  try {
    await deleteUser(row.id)
    alert('删除成功')
    loadData()
  } catch (err) {
    console.error('删除失败', err)
    alert('删除失败')
  }
}
</script>