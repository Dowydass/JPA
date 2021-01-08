import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class AirportDAO {
    public static void insert(Airport airport) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(airport);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static ArrayList<Airport> searchByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        ArrayList<Airport> airports = (ArrayList<Airport>) entityManager.
                createQuery("SELECT a FROM Airport a WHERE a.name LIKE :name2").
                setParameter("name2", name).
                getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return airports;
    }

    public static void deleteById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Airport airport = entityManager.find(Airport.class, id);
        entityManager.remove(airport);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void updateById(Airport airport, int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Airport airport1 = entityManager.find(Airport.class, id);
        airport1.setName(airport.getName());
        airport1.setAddress(airport.getAddress());
        airport1.setCity(airport.getCity());

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static void deleteByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Airport airport = entityManager.find(Airport.class, name);
        entityManager.remove(airport);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
