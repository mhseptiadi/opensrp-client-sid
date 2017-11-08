package org.smartregister.gizi.provider;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.smartregister.commonregistry.CommonPersonObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.commonregistry.CommonRepository;
import org.smartregister.cursoradapter.SmartRegisterCLientsProviderForCursorAdapter;
import org.smartregister.domain.Alert;
import org.smartregister.gizi.R;
import org.smartregister.service.AlertService;
import org.smartregister.util.DateUtil;
import org.smartregister.util.OpenSRPImageLoader;
import org.smartregister.util.Utils;
import org.smartregister.view.activity.DrishtiApplication;
import org.smartregister.view.contract.SmartRegisterClient;
import org.smartregister.view.contract.SmartRegisterClients;
import org.smartregister.view.dialog.FilterOption;
import org.smartregister.view.dialog.ServiceModeOption;
import org.smartregister.view.dialog.SortOption;
import org.smartregister.view.viewholder.OnClickFormLauncher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import util.GiziConstants;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static org.smartregister.util.Utils.fillValue;
import static org.smartregister.util.Utils.getName;
import static org.smartregister.util.Utils.getValue;

/**
 * Created by soran on 08/11/17.
 */

public class ChildSmartClientsProvider implements SmartRegisterCLientsProviderForCursorAdapter {
    private final LayoutInflater inflater;
    private final Context context;
    private final View.OnClickListener onClickListener;
    private final AlertService alertService;
    private final AbsListView.LayoutParams clientViewLayoutParams;
    private final CommonRepository commonRepository;

    public ChildSmartClientsProvider(Context context, View.OnClickListener onClickListener,
                                     AlertService alertService,  CommonRepository commonRepository) {
        this.onClickListener = onClickListener;
        this.context = context;
        this.alertService = alertService;
        this.commonRepository = commonRepository;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        clientViewLayoutParams = new AbsListView.LayoutParams(MATCH_PARENT, (int) context.getResources().getDimension(org.smartregister.R.dimen.list_item_height));
    }

    @Override
    public void getView(Cursor cursor, SmartRegisterClient client, final View convertView) {
        CommonPersonObjectClient pc = (CommonPersonObjectClient) client;

/*        viewHolder.name = (TextView)convertView.findViewById(R.id.txt_child_name);
        viewHolder.fatherName = (TextView) convertView.findViewById(R.id.ParentName);
        viewHolder.subVillage = (TextView) convertView.findViewById(R.id.txt_child_subVillage);*/

        //fillValue((TextView) convertView.findViewById(R.id.child_zeir_id), getValue(pc.getColumnmaps(), GiziConstants.KEY.ZEIR_ID, false));

        String firstName = getValue(pc.getColumnmaps(), "namaBayi", true);

        fillValue((TextView) convertView.findViewById(R.id.txt_child_name), firstName);

        /*String lastName = getValue(pc.getColumnmaps(), GiziConstants.KEY.LAST_NAME, true);
        String childName = getName(firstName, lastName);

        String motherFirstName = getValue(pc.getColumnmaps(), GiziConstants.KEY.MOTHER_FIRST_NAME, true);
        if (StringUtils.isBlank(childName) && StringUtils.isNotBlank(motherFirstName)) {
            childName = "B/o " + motherFirstName.trim();
        }
        fillValue((TextView) convertView.findViewById(R.id.child_name), childName);

        String motherName = getValue(pc.getColumnmaps(), GiziConstants.KEY.MOTHER_FIRST_NAME, true) + " " + getValue(pc, GiziConstants.KEY.MOTHER_LAST_NAME, true);
        if (!StringUtils.isNotBlank(motherName)) {
            motherName = "M/G: " + motherName.trim();
        }
        fillValue((TextView) convertView.findViewById(R.id.child_mothername), motherName);*/
        

    }

    

    @Override
    public SmartRegisterClients updateClients(FilterOption villageFilter, ServiceModeOption
            serviceModeOption, FilterOption searchFilter, SortOption sortOption) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void onServiceModeSelected(ServiceModeOption serviceModeOption) {

    }

    @Override
    public OnClickFormLauncher newFormLauncher(String formName, String entityId, String
            metaData) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public View inflatelayoutForCursorAdapter() {
        return inflater().inflate(R.layout.smart_register_gizi_client, null);
    }

    public LayoutInflater inflater() {
        return inflater;
    }

   

    

       

  


}
