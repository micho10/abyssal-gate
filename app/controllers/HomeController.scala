package controllers

import javax.inject._

import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the application's home page.
 *
 * Controllers MUST be defined as classes, to take advantage of Dependency Injection (DI)
 *
 * The @Inject tag indicates it's using an injected routes generator.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request => Ok(views.html.index("Landed by HTML5 UP")) }

}
