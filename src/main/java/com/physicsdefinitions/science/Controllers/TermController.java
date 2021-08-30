
/*
 * package com.physicsdefinitions.science.Controllers;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import com.physicsdefinitions.science.Models.Term; import
 * com.physicsdefinitions.science.Services.TermService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class TermController {
 * 
 * @Autowired private TermService term;
 * 
 * TermController(TermService term) { this.term = term; }
 * 
 * @GetMapping("curriculum/{curriculum_name}/terms")
 * 
 * @ResponseBody public List<Term> getAllTerms() { return term.getAllTerms(); }
 * 
 * @GetMapping("curriculum/{curriculum_name}/topic/{id}")
 * 
 * @ResponseBody public List<Term> getTopicTerms(@PathVariable("id") int
 * id,@PathVariable("curriculum_name")) { return term.getTermsForTopic(id); }
 * 
 * @GetMapping("/term/{id}")
 * 
 * @ResponseBody public Optional<Term> getTerm(@PathVariable("id") int id) {
 * return term.getTerm(id); }
 * 
 * }
 */