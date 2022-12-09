<template>
  <div>
    <button class="btn btn-primary m-3">
      <router-link to="/" class="nav-link text-white">Back</router-link>
    </button>

    <div>
      <div 
        class="p-4 border border-primary"
        id="box"
        style="width: fit-content; margin: auto; margin-top: 5%"
      >
        <div>
          <h1 class="text-center">Add Student</h1>
        </div>
      
        <form @submit.prevent="inputStudent">
          <div class="form-row d-flex">
            <div class="col-md-6 mb-3">
              <label for="validationDefault01">Student Name</label>
              <input
                v-model="studentData.nama"
                type="text"
                class="form-control"
                placeholder="Full Name"
              />
            </div>
            <div class="col-md-6 mb-3">
              <label for="validationDefault02">Soft Skill</label>
              <input
                v-model="studentData.soft_skill"
                type="text"
                class="form-control"
                placeholder=""
                value=""
              />
            </div>
          </div>

          <div class="form-row">
            <div class="col-md-3 mb-3">
              <label for="validationDefault01">Student Age</label>
              <input
                v-model="studentData.umur"
                type="number"
                class="form-control"
                id="age"
                placeholder="Age"
                value=""
              />
            </div>
            <div class="col-md-3 mb-3">
              <label for="validationDefault02">Gender</label>
              <select v-model="studentData.jenis_kelamin" class="custom-select" id="inputGroupSelect02">
                <option selected></option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
              </select>
            </div>
            <div class="col-md-6 mb-3">
              <label for="validationDefault02">Hard Skill</label>
              <input
                v-model="studentData.hard_skill"
                type="text"
                class="form-control"
                id="hardskill"
                placeholder=""
                value=""
              />
            </div>
          </div>

          <div class="form-row">
            <div class="col mb-6">
              <label for="Email">Email</label>
              <input
                v-model="studentData.email"
                type="text"
                class="form-control"
                placeholder=""
              />
            </div>

            <div class="col mb-6">
              <label for="Interest">Interest</label>
              <select v-model="studentData.interest" class="custom-select" id="inputGroupSelect02">
                <option selected></option>
                <option value="Web Frontend">Web Frontend</option>
                <option value="Web Backend">Web Backend</option>
                <option value="Mobile Apps">Mobile Apps</option>
                <option value="Network">Network</option>
                <option value="Data Science">Data Science</option>
              </select>
            </div>
          </div>
          <div class="form-col mt-3">
            <div>
              <label for="Description">Description</label>
            </div>
            <div>
              <textarea
                v-model="studentData.deskripsi_diri"
                name=""
                id=""
                cols="75"
                rows="5"
              ></textarea>
            </div>
          </div>
          <div>
            <button type="submit" id="submitdata" class="btn btn-primary p-3 mt-4">
              Submit
            </button>
          </div>
        </form>
        <!-- <SuccessForm v-show="success"></SuccessForm> -->
      </div>
      </div>
    </div>
</template>

<script>
import studentService from "../services/StudentService";
// import SuccessForm from "./SuccessForm.vue";
import Swal from 'sweetalert2'

export default {
  data() {
    return {
      studentData: {
        deskripsi_diri: null,
        email: null,
        hard_skill: null,
        interest: null,
        jenis_kelamin: null,
        nama: null,
        soft_skill: null,
        umur: null,
      },
      success: false,
      buttonValue: "Submit",
    };
  },

  methods: {
    inputStudent() {
      let data = this.studentData;
                if(this.buttonValue === "Submit"){
                    studentService.create(data)
                        .then(response => {
                            console.log(response.data);
                        });
                        Swal.fire({
                          position: 'center',
                          icon: 'success',
                          title: 'Your work has been saved',
                          timer: 2000,
                          timerProgressBar:true,
                        }).then(()=>{
                          this.$router.push("/")
                        // .catch(() => {
                        //     this.$router.push("/")
                        })
                        
                        
                }else{
                    studentService.updateStudent(data.id, data)
                        .then(response => {
                            console.log(response.data);
                        })
                        Swal.fire({
                          position: 'center',
                          icon: 'success',
                          title: 'Your work has been saved',
                          timer: 2000,
                          timerProgressBar:true,
                        }).then(()=>{
                          this.$router.push("/")
                        // .catch(() => {
                        //     this.$router.push("/")
                        })
                        // .catch(e => {
                        //     console.log(e);
                        // });
                }
            },

    selectIdStudent(id) {
      studentService
      .selectIdStudent(id)
      .then(response => {
        this.studentData = response.data;
      })
    }

  },
  components: {
    // SuccessForm,
  },
  mounted() {
    if(this.$route.name == 'UpdateData'){
      this.selectIdStudent(this.$route.params.id);
      this.buttonValue = "update";
    }
  },

};
</script>

<style></style>
