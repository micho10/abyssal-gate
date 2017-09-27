package controllers

import javax.inject.Inject
import javax.inject.Singleton

import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the application's home page.
 *
 * Controllers MUST be defined as classes, to take advantage of Dependency Injection (DI)
 *
 * The @Inject tag indicates it's using an injected routes generator.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET` request
    * with a path of `/index`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }


  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET` request
    * with a path of `/elements`.
    */
  def elements() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.elements.elements())
  }


  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET` request
    * with a path of `/elements`.
    */
  def leftSidebar() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.elements.leftSidebar())
  }


  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET` request
    * with a path of `/elements`.
    */
  def rightSidebar() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.elements.rightSidebar())
  }


  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET` request
    * with a path of `/elements`.
    */
  def noSidebar() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.elements.noSidebar())
  }

}
