
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="main.css">



</head>
<body>
	<nav>
		<ul>
			<li><a href="#home">Hello ${user.getFirstName()}</a></li>
			<li class=""><a href="#news">News</a></li>
			<li class=""><a href="#contact">Contact</a></li>
			<li class=""><a href="#about">About</a></li>
			<li class="login"><a class="login-trigger">SING UP <span>+</span></a>
				</a>
				<div class="login-content">
					<form action="registration" method="post">
						<fieldset class="inputs">
							<input class="username" type="text" name="username"
								placeholder="Your name" required> <input
								class="usercity" type="text" name="city" placeholder="Your City"
								required> <input class="username" type="email"
								name="email" placeholder="Your email address" required>
							<input class="password" type="password" name="pass"
								placeholder="Password" required>
						</fieldset>
						<fieldset class="actions">
							<input type="submit" class="submit" value="Sing up"> <label><input
								type="checkbox" checked="checked"> Keep me signed in</label>
						</fieldset>
					</form>
				</div></li>
			<li class="login"><a class="login-trigger">SING IN <span>+</span>
			</a>
				<div class="login-content">
					<form action="login" method="post">
						<fieldset class="inputs">
							<input class="username" type="email" name="email"
								placeholder="Your email address" required> <input
								class="password" type="password" name="pass"
								placeholder="Password" required>
						</fieldset>
						<fieldset class="actions">
							<input type="submit" class="submit" value="Sing in"> <label><input
								type="checkbox" checked="checked"> Keep me signed in</label>
						</fieldset>
					</form>
				</div></li>
		</ul>
	</nav>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.login-trigger').click(function() {
				$(this).next('.login-content').slideToggle();
				$(this).toggleClass('active');

				if ($(this).hasClass('active'))
					$(this).find('span').html('&#x25B2;')
				else
					$(this).find('span').html('&#x25BC;')
			})
		});
	</script>
</body>
</html>
