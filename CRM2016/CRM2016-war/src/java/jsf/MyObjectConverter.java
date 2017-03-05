package jsf;
//http://stackoverflow.com/questions/17748706/selectonemenu-jsf-on-objects-with-converter
import entities.Etudiant;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sessions.EtudiantFacade;

@FacesConverter("myObjectConverter")
public class MyObjectConverter implements Converter {
    
    @EJB
    EtudiantFacade MyController;
    private List<Etudiant> objects;

    public MyObjectConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        this.objects = MyController.findAll();
        if (value.getClass().getName()!=Integer.class.getName()) {
            return null;
        }
        return this.getMyObject(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        this.objects = MyController.findAll();
        if (value == null) {
            return null;
        }
        return String.valueOf(((Etudiant) value).getId()).toString();
    }

    public Etudiant getMyObject(String id) {
        
        this.objects = MyController.findAll();
        Iterator<Etudiant> iterator = this.objects.iterator();
        while (iterator.hasNext()) {
           Etudiant object = iterator.next();

            if (object.getId() == Integer.valueOf(id).intValue()) {
                return object;
            }
        }
        return null;
    }



}
