package org.gofleet.openLS.ddbb.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.PointType;
import net.opengis.xls.v_1_2_0.AddressType;
import net.opengis.xls.v_1_2_0.NamedPlaceClassification;
import net.opengis.xls.v_1_2_0.NamedPlaceType;
import net.opengis.xls.v_1_2_0.StreetAddressType;
import net.opengis.xls.v_1_2_0.StreetNameType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.postgresql.jdbc4.Jdbc4Array;

/**
 *
 * @author lroman
 */
public abstract class PostGisUtils {

    static Log LOG = LogFactory.getLog(PostGisUtils.class);

    public static PointType getReferencedPoint(PGgeometry g) {
        Point center = g.getGeometry().getFirstPoint();
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(center.getX());
        list.add(center.getY());
        PointType point = new PointType();
        DirectPositionType pos = new DirectPositionType();
        pos.setValue(list);
        point.setPos(pos);
        return point;
    }

    public static AddressType getAddress(Jdbc4Array address)
            throws SQLException {

        LOG.trace("Address returned" + address.toString());

        String[] fields = StringUtils.split(address.toString(), ",");

        AddressType value = new AddressType();
        value.setCountryCode(fields[fields.length - 1]);
        StreetAddressType street_ = new StreetAddressType();
        StreetNameType streetName = new StreetNameType();
        streetName.setValue(fields[0].substring(1, fields[0].length() - 1));
        street_.getStreet().add(streetName);
        value.setStreetAddress(street_);
        NamedPlaceType namedPlace = new NamedPlaceType();
        namedPlace.setType(NamedPlaceClassification.MUNICIPALITY);
        namedPlace.setValue(fields[2].substring(1, fields[2].length() - 1));
        namedPlace = new NamedPlaceType();
        namedPlace.setType(NamedPlaceClassification.MUNICIPALITY_SUBDIVISION);
        namedPlace.setValue(fields[1].substring(1, fields[1].length() - 2));
        namedPlace = new NamedPlaceType();
        namedPlace.setType(NamedPlaceClassification.COUNTRY_SUBDIVISION);
        namedPlace.setValue(fields[3].substring(1, fields[3].length() - 3));
        value.getPlace().add(namedPlace);
        return value;
    }
}
