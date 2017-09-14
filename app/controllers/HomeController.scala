package controllers


import javax.inject.{Inject, Singleton}

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

/**
 * This controller creates an `Action` to handle HTTP requests to the application's home page.
 *
 * Controllers MUST be defined as classes, to take advantage of Dependency Injection (DI)
 *
 * The @Inject tag indicates it's using an injected routes generator.
 */
@Singleton
class HomeController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request => Ok(views.html.index("Landed by HTML5 UP")) }

}
