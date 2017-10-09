package pl.coderslab.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorData implements Serializable {


    private static final long serialVersionUID = -5187358075786175625L;


    private String currentVisitorName;
    private String currentVisitorEmail ;
    private List<Visitor> visitors = new ArrayList<Visitor>();


    public VisitorData(String currentVisitorName, String currentVisitorEmail, List<Visitor> visitors) {
        this.currentVisitorName = currentVisitorName;
        this.currentVisitorEmail = currentVisitorEmail;
        this.visitors = visitors;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    @Override
    public String toString() {
        return "VisitorData{" +
                "currentVisitorName='" + currentVisitorName + '\'' +
                ", currentVisitorEmail='" + currentVisitorEmail + '\'' +
                ", visitors=" + visitors +
                '}';
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCurrentVisitorName() {
        return currentVisitorName;
    }

    public void setCurrentVisitorName(String currentVisitorName) {
        this.currentVisitorName = currentVisitorName;
    }

    public String getCurrentVisitorEmail() {
        return currentVisitorEmail;
    }

    public void setCurrentVisitorEmail(String currentVisitorEmail) {
        this.currentVisitorEmail = currentVisitorEmail;
    }

}
