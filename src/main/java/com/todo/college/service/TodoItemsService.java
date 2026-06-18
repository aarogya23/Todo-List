package com.todo.college.service;

import com.todo.college.model.TodoItems;
import com.todo.college.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoItemsService {

    @Autowired
    private AuthService authService;

    private List<TodoItems> todos =
            new ArrayList<>();

    private Long counter = 1L;


    // ================= CREATE =================

    public String createTodo(
            String token,
            TodoItems todo){

        User user =
                authService.validateUser(token);

        if(user == null){

            return "Unauthorized";
        }

        todo.setId(counter++);

        todo.setUserId(
                user.getId()
        );

        todos.add(todo);

        return "Todo created successfully";
    }


    // ================= GET =================

    public List<TodoItems> getTodos(
            String token){

        User user =
                authService.validateUser(token);

        List<TodoItems> result =
                new ArrayList<>();

        if(user == null){

            return result;
        }

        for(TodoItems todo : todos){

            if(todo.getUserId()
                    .equals(user.getId())){

                result.add(todo);
            }
        }

        return result;
    }


    // ================= UPDATE =================

    public String updateTodo(
            String token,

            Long id,

            TodoItems updatedTodo){

        User user =
                authService.validateUser(token);

        if(user == null){

            return "Unauthorized";
        }

        for(TodoItems todo : todos){

            if(todo.getId().equals(id)

                    &&

                    todo.getUserId()
                            .equals(user.getId())){

                todo.setTopic(
                        updatedTodo.getTopic()
                );

                todo.setDescription(
                        updatedTodo.getDescription()
                );

                return "Todo updated successfully";
            }
        }

        return "Todo not found";
    }



    // ================= DELETE =================

    public String deleteTodo(
            String token,

            Long id){

        User user =
                authService.validateUser(token);

        if(user == null){

            return "Unauthorized";
        }

        Iterator<TodoItems> iterator =
                todos.iterator();

        while(iterator.hasNext()){

            TodoItems todo =
                    iterator.next();

            if(todo.getId().equals(id)

                    &&

                    todo.getUserId()
                            .equals(user.getId())){

                iterator.remove();

                return "Todo deleted successfully";
            }
        }

        return "Todo not found";
    }

}
