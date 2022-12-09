<template>
    <div class="d-flex">

        <div v-for="(item, index) in studentData" :key="item.id">
        <div class="card m-4" style="width: 18rem;">
            <p class="d-none"> {{ index +1}}</p>
            <div class="card-body">

            <h4 class="card-title">{{ item.nama + "," + " " + item.umur + " " + " Year Old" }}</h4> <hr>
            <h6 class="card-subtitle mb-2 text-muted">{{ item.deskripsi_diri }}</h6>
            <p class="card-text">{{ "Email :" + item.email }}</p>
            <p class="card-text">{{ "Soft Skill     :" + item.soft_skill }}</p>
            <p class="card-text">{{ "Hard Skill     :" + item.hard_skill }}</p>
            <p class="card-text">{{ "Interest       :" + item.interest }}</p>

            <router-link :to="{ name:'UpdateData', params:{id:item.id }}"><button class="btn btn-sm btn-primary mr-2 text-white">Update</button></router-link>
            <button class="btn btn-sm btn-danger" @click="deleteStudentFunc(item.id, index)">Delete</button>
            <img style="width:21%; margin-left:10%" src="../assets/male.png" alt="" v-show="item.jenis_kelamin === 'Male' ">
            <img style="width:14%; margin-left:10%" src="../assets/female.png" alt="" v-show="item.jenis_kelamin === 'Female' ">
         </div>
        </div>
        
    </div>
    </div>
</template>

<script>
import studentService from '../services/StudentService'
import Swal from 'sweetalert2'

export default {
  name: 'CardVue',
    methods : {
        getStudent(){
            studentService.getAll()
                .then(response => {
                    this.studentData = response.data;
                    console.log(this.studentData);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        deleteStudentFunc(id, index){
            // if(confirm("Apakah anda yakin hapus?")){
            //     studentService.deleteStudent(id)
            //         .then(response => {
            //             console.log(response.data);
            //             this.studentData.splice(index,1)
            //         })
            //         .catch(e => {
            //             console.log(e);
            //         });
            //         Swal.fire("Hapus Berhasil", "With some body text and success icon!", "success");
            //     // location.reload();
            // }else{
            //     this.$alert("Hapus dibatalkan!")
            // }

            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success m-3',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
                })

                swalWithBootstrapButtons.fire({
                title: 'Are you sure?',
                text: "You Won't Be Able To Revert This!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel!',
                reverseButtons: true
                }).then((result) => {

                if (result.isConfirmed) {
                    studentService.deleteStudent(id)
                    .then(response => {
                        console.log(response.data);
                        this.studentData.splice(index,1)
                    })
                    .catch(e => {
                        console.log(e);
                    });
                    swalWithBootstrapButtons.fire(
                    'Deleted!',
                    'Your Data Has Been Deleted.',
                    'success'
                    )
                    
                } else if (
                    /* Read more about handling dismissals below */
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your Data Is Safe :)',
                    'error'
                    )
                }
                })


        }
    },
    mounted(){
        this.getStudent();
    },
    data(){
        return{
            studentData : null,
        }
    }
}
</script>

<style>

</style>