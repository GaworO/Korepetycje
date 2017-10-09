package pl.coderslab.session;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {


    public VisitorCount visitorCount(VisitorCount vc){
        vc.setCount(vc.getCount() + 1 );
        return vc ;
    }

    public void registerVisitr(VisitorData sessionData , VisitorData incomingData ){
        List<Visitor> visitors = sessionData.getVisitors() ;
        sessionData.setCurrentVisitorName(incomingData.getCurrentVisitorName());
        sessionData.setCurrentVisitorName(incomingData.getCurrentVisitorEmail());
        visitors.add(new Visitor(incomingData.getCurrentVisitorName() , incomingData.getCurrentVisitorEmail()));

    }







}
