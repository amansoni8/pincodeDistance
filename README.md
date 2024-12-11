# Pincode Distance

# Pincode Distance API

This project provides a REST API that calculates the distance and duration between two given pincodes using the Google Maps API. The application caches the response to optimize repeated API calls and stores the distance, duration, and route information in a database.


## Technologies

- **Spring Boot**: For building the REST API.
- **Google Maps API**: For fetching route data.
- **H2 Database**: For storing distance, duration, and route data.
- **Spring Data JPA**: For database interaction.
- **OkHttp3**: For making HTTP requests to the Google Maps API.


## API Documentation
Application is running on Port:8090

### Endpoints

#### `GET /api/routes`
Fetches the distance and duration between two pincodes.

- **Request Parameters**:
  - `fromPincode` (required): The starting pincode.
  - `toPincode` (required): The destination pincode.

**Example Request**:
GET **http://localhost:8090/api/routes?fromPincode=500082&toPincode=110060**

**Example output**
{
    "id": 1,
    "fromPincode": "500082",
    "toPincode": "110060",
    "distance": 1560.32,
    "duration": "1 day 5 hours",
    "routeDetails": "etjiBgwy}McgByrEo{C`vAohMssBewLvWid]xdBa`VzM_rJ~_@guBucAgjDtoB}~Gl{CekEzPcmEms@q_F~eBogHl_DeoG`m@u}MruDwyFft@iR``Ga`OrmKipHlzCeoE_e@_gIibA{lHxtDigJyjCoxH}nGeoDw^kyBwxCm{DybAuyQgaIchSkzA{bI`fDmaEejCazG{vC}oCwmGs|B}xCy|EtxDmdCjaD_tAlOoxA}hBamDj`CuuEqh@mpIg}CceVeeKchKof@koIhaBunKawAcpEenAsxD{nDwpEw~BmvG{mAihHtd@yhFtcEcrLr`@yyGgDg{EkgAerHwyBkpD{`GcyLklKu`QywG_wOst@{aJemBinIivEacHm{Aiz@ioCeIycDc~Cq{DinHqjJmrM|e@skScrEcfLi|@_}TmbJcwGsgCgc@gwBodFeqIoaDamJ}tIyn@efDidLuoEq_As`RhjEkhLy~A{oHkrDi|Gy`GyxDyp@gvHqjCsbQatHq|e@sdTkmDopBkvGkMkhZuj@ukVmOurTqdAg|Pvu@g`Hkz@k{EkfCmhFay@uuNm`D_kFn`C_oEl~E{`@baEq{D~\\mtGxqAorGv}HkxFfsCerEvdHa~DfwKg}Fd~EkgEl_Jca@xgLjfAf}F`dAdjDihBjfAse@`oFkwEdyAssG}lBmjL||@_j[s`C}vYrfD_lEvf@eeLr|FwdFttGqwKhpIcgHrmEa}H~iDocMnf@q|IohA{rJodA}yBlLfPvkDsiCnbHczAjbGakDbqEohGfxBeoP|kGsxYfuEylUxgJynGuqAyePrrBwbIl`DkvEbMidIlqFe_Fp|AgeCe{AoeNh_CalPmvDgxFkrC{}Jdw@ejHbo@goG`uE_iBd_By|Co}Au}FugBekTgiAuoUsyNcqGl{AmlG~pGi{FhLg]qnBukDmdHotEpfDckHnlD{jPrqG_pg@fyPevEl`A_lCt~CuqKzeHi|BvzC{qCmJwhDl_@i}NrnE{kLocF_jEo{Di{D}hAqbDxlA__ChtG}~@`lQol@~nEg~FhxCykIdgFcjKd~K_`Z`nHqhE|iDuxG`bAqg`@mnEygTafDoaTyvF_LwuHqhD}|EqvG_yFyyF`RimBqa@u~BvcDk}GvbIq~ChcQsaBrhMsuDfhF{rKzpIy{R~|B_nWnfEcw[dcAsrE}Yi}DzzCi{Jx~KamVvtG_gLd_BunK`u@cz\\`kBa{SbpGqq@dlDgtM|uRs`Mf~NgjEvxBsNdoEf\\dtDmlAbhD"
}
