package susitio.comptabilite.project.controllers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	public void setDataSource() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@PostMapping("/logout")
	public void logout(@RequestBody String email) {
		setDataSource();
		String sql = "DELETE from oauth_access_token where user_name= ?";
		jdbcTemplate.update(sql, email);
	}
}