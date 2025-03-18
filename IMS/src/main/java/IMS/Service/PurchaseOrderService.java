package IMS.Service;

import java.util.List;

import IMS.Master.PurchaseOrderMaster;

public interface PurchaseOrderService {

    public Boolean addPurchaseOrder(PurchaseOrderMaster purchaseOrder);
    public Boolean updatePurchaseOrder(PurchaseOrderMaster purchaseOrder);
    public Boolean deletePurchaseOrder(PurchaseOrderMaster purchaseOrder);
    public PurchaseOrderMaster getPurchaseOrder(Integer poId);
    public List<PurchaseOrderMaster> getAllPurchaseOrders();
    
}
