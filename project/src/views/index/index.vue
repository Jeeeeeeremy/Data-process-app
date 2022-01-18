<template>
  <div>
    <DownLoad
      :tableData="tableData"
      :tableHead="excelHeaders"
      :total="total"
      :title="excelTitle"
      class="m-10"
      @insert="add"
    />
    <el-table :data="tableData" width="100%" :height="MaxHeight">
      <el-table-column prop="id" align="center" label="序号"> </el-table-column>
      <el-table-column prop="child1" align="center" label="列名1">
      </el-table-column>
      <el-table-column prop="child2" align="center" label="列名2">
      </el-table-column>
      <el-table-column prop="child3" align="center" label="列名3">
      </el-table-column>
      <el-table-column prop="child4" align="center" label="列名4">
      </el-table-column>
      <el-table-column prop="child5" align="center" label="列名5">
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            @click="update(scope.row)"
            >修改</el-button
          >
          <el-button
            type="danger"
            icon="el-icon-delete"
            @click="deletes(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="80%"
      top="2vh"
    >
      <el-input
        v-model="input1"
        placeholder="请输入列1内容"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input2"
        placeholder="请输入列2内容"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input3"
        placeholder="请输入列3内容"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input4"
        placeholder="请输入列4内容"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input5"
        placeholder="请输入列5内容"
        class="m-10"
      ></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button v-if="hanllerule===1" type="primary" @click="handleadd()">添 加</el-button>
        <el-button v-if="hanllerule===2" type="primary" @click="handleupdate()">修 改</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getMessage, deleteMessage, updateMessage, insertMessage } from "@/server/api.js";
export default {
  components: {
    DownLoad: () => import("@/components/Excel/index.vue"),
  },
  data() {
    return {
      tableData: [],
      excelHeaders: ["序号", "列名1", "列名2", "列名3", "列名4", "列名5"],
      total: 0,
      excelTitle: "导出csv",
      dialogVisible: false,
      title:'',
      input1: "",
      input2: "",
      input3: "",
      input4: "",
      input5: "",
      id: 0
    };
  },
  computed: {
    MaxHeight() {
      var height = document.body.height;
      return height - 80;
    },
    hanllerule() {
      var result = this.title==='add'? 1 : 2
      return result
    }
  },
  watch: {
    dialogVisible(newValue) {
      if (!newValue) {
        this.input1 = "";
        this.input2 = "";
        this.input3 = "";
        this.input4 = "";
        this.input5 = "";
        this.id = 0;
      }
    },
  },
  mounted() {
    this.init();
  },

  methods: {
    init() {
      getMessage().then((res) => {
        if (res.status === 200) {
          this.tableData = res.data;
          this.total = res.data.length;
        } else {
          this.$message.wraning("请求参数失败!");
        }
      });
    },
    add(){
     this.title = 'add';
     this.dialogVisible = true;
    },
    update(row) {
      this.title = 'update';
      this.id = row.id;
      this.input1 = row.child1;
      this.input2 = row.child2;
      this.input3 = row.child3;
      this.input4 = row.child4;
      this.input5 = row.child5;
      this.dialogVisible = true;
    },
    handleupdate() {
      var obj = {
        id:this.id,
        child1:this.input1,
        child2:this.input2,
        child3:this.input3,
        child4:this.input4,
        child5:this.input5
      }
      updateMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("修改成功!");
          this.dialogVisible = false
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("当前列不存在!");
        } else {
          this.$message.error("程序修改异常!");
        }
      });
    },
    handleadd(){
      var obj = {
        child1:this.input1,
        child2:this.input2,
        child3:this.input3,
        child4:this.input4,
        child5:this.input5
      }
      insertMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("添加成功!");
          this.dialogVisible = false
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("已经存在!");
        } else {
          this.$message.error("程序添加异常!");
        }
      })  
    },
    deletes(id) {
      var obj = { id: id };
      deleteMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("删除成功!");
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("当前列不存在!");
        } else {
          this.$message.error("程序删除异常!");
        }
      });
    },
  },
};
</script>
<style lang='scss' scoped>
.m-10 {
  margin: 10px;
}
</style>