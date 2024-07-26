import ApiService from './apiservice'



class TaskService extends ApiService {
    constructor(){
        super('/task')
    }
    create(task){
        return this.post('', task);
    }
}

export default TaskService;