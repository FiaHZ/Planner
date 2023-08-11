/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Task;

import Controllers.Controller;
import Models.Members.Member;
import Views.View;
import java.util.ArrayList;

/**
 *
 * @author jprod
 */
public class TaskController implements Controller<Task> {
    private TaskList list;
    private View view;
    
    public TaskController(View view) {
        list=TaskList.getInstance();
        this.view=view;
    }
    
    @Override
    public void insert(Task obj) {
        if (obj.isComplete()){
            this.list.insert(obj);
            this.readAll();
        }else{
            this.view.displayErrorMessage("Faltan datos");
        }
    }

    @Override
    public void update(Task obj) {
        if (obj.isComplete()){
            this.list.update(obj);
            this.readAll();
        }else{
            this.view.displayErrorMessage("Faltan datos");
        }
    }

    @Override
    public void delete(Task obj) {
        if (this.list.delete(obj)){
            this.readAll();
        }else{
            this.view.displayErrorMessage("El miembro no se encuentra registrado");
        }
    }

    @Override
    public void read(Object id) {
        Task task=this.list.search(id);
        if (task!=null){
            this.view.display(task);
        }else{
            this.view.displayErrorMessage("El miembro buscado no se encuentra registrado");
        }
    }

    @Override
    public void readAll() {
        Task[] tasks=this.list.toArray();
        if (tasks.length>0){
            this.view.displayAll(tasks);
        }
    }
    
}
