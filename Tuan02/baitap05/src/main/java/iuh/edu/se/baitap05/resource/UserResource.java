package iuh.edu.se.baitap05.resource;

import iuh.edu.se.baitap05.dao.UserDao;
import iuh.edu.se.baitap05.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDao dao = new UserDao();

    @GET
    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) throws SQLException {
        User user = dao.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    public Response addUser(User user) throws SQLException {
        dao.addUser(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") int id, User user) throws SQLException {
        dao.updateUser(id, user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) throws SQLException {
        dao.deleteUser(id);
        return Response.noContent().build();
    }
}
