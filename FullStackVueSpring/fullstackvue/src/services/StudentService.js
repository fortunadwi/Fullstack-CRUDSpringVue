import http from "../http-common";

class studentService {
    create(data){
        return http.post("/student/insert",data);
    }

    getAll() {
        return http.get("/student/getAll");
    }

    deleteStudent(id) {
        return http.delete(`/student/delete/${id}`);
      }
    
      updateStudent(id, data) {
        return http.put(`/student/update/${id}`, data);
      }

      selectIdStudent(id) {
        return http.get(`/student/getId/${id}`);
      }
}

export default new studentService();