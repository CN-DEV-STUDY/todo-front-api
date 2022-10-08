package com.todo.cn.controller.todo;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.domain.TodoVO;
import com.todo.cn.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;


    @GetMapping("/list/{uno}")
    public String list(@PathVariable int uno , Model model){
        List<GetTodoRes> list = service.getList(uno);
        model.addAttribute("uno", uno);
        model.addAttribute("list" , list);

        return "list";
    }

    @GetMapping("/bin/{uno}")
    @ResponseBody
    public ResponseEntity<List<GetTodoRes>> bin(@PathVariable int uno , Model model){
        List<GetTodoRes> binList = service.getBinList(uno);
        return new ResponseEntity<>(binList ,HttpStatus.OK);
    }

    @PostMapping("/register")
    public String register(PostTodoReq ptr , RedirectAttributes redirectAttributes){
        service.register(ptr);
        redirectAttributes.addAttribute("uno", ptr.getUno());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/todo/list/{uno}";
    }

    @PostMapping("/modify/{tno}")
    public String update(@PathVariable int tno, PostTodoReq ptr , RedirectAttributes redirectAttributes){
        service.modify(ptr);
        redirectAttributes.addAttribute("uno", ptr.getUno());
        return "redirect:/todo/list/{uno}";

    }

    @PostMapping("/delete/{tno}")
    public String delete(@PathVariable int tno , RedirectAttributes redirectAttributes){
        TodoVO todoVO = service.selectTodo(tno);
        service.removeAndInsertBin(todoVO);
        redirectAttributes.addAttribute("uno", todoVO.getUno());
        return "redirect:/todo/list/{uno}";

    }

    // 휴지통에서 복구버튼 클릭시 할일 리스트 페이지로 복구
    @PostMapping("/restore/{tno}")
    public String restoreTodo(@PathVariable int tno , RedirectAttributes redirectAttributes){
        service.restoreTodo(tno);
        TodoVO todoVO = service.selectTodo(tno);
        redirectAttributes.addAttribute("uno", todoVO.getUno());
        return "redirect:/todo/list/{uno}";
    }
    
    // 휴지통에서 영구삭제
    @PostMapping("/removeBinPer/{tno}")
    public String removeBinPer(@PathVariable int tno , RedirectAttributes redirectAttributes){
        service.removeTodoPer(tno);
        TodoVO todoVO = service.selectTodo(tno);
        redirectAttributes.addAttribute("uno", todoVO.getUno());
        return "redirect:/todo/list/{uno}";
    }

/**
 * API
    @PostMapping(value = "/register" , consumes = "application/json" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> create(@RequestBody PostTodoReq ptr){
        int result = service.register(ptr);
        return result == 1 ? new ResponseEntity<Integer>(result,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/list/{uno}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GetTodoRes>> getList(@PathVariable("uno") int uno){
        return new ResponseEntity<>(service.getList(uno), HttpStatus.OK);
    }

    @PutMapping(value = "/modify/{tno}" , consumes = "application/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostTodoReq> modify(@PathVariable("tno") int tno ,@RequestBody PostTodoReq ptr){
        ptr.setTno(tno);
        int result = service.modify(ptr);
        return result == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value = "/delete/{tno}")
    public ResponseEntity<TodoVO> delete(@PathVariable("tno") int tno){
        TodoVO todoVO = service.selectTodo(tno);

        service.removeAndInsertBin(todoVO);

        return new ResponseEntity<TodoVO>(HttpStatus.OK);
    }

    @GetMapping("/selectCount/{uno}")
    public int todoCnt(@PathVariable("uno") int uno){
        int result = service.todoCnt(uno);
        return result;
    }

    @PutMapping(value = "/restore/{tno}")
    public void restoreTodo(@PathVariable int tno){
        service.restoreTodo(tno);

    }
*/
}